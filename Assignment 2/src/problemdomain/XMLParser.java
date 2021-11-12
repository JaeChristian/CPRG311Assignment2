package problemdomain;
import utility.*;
import java.io.*;
import java.util.Scanner;

public class XMLParser {
	private static File file;
	private static String filePath = "res/sample3.xml";
	private Scanner readFile;
	
	private MyStack<String> stack = new MyStack<>();
	private MyQueue<String> errorQ = new MyQueue<>();
	private MyQueue<String> extrasQ = new MyQueue<>();
	
	public XMLParser() throws FileNotFoundException {
		try {
			file = new File(filePath);
			readFile = new Scanner(file);
		}
		catch(FileNotFoundException ex) {
			System.out.println("File not found");
			return;
		}
		parseFile();
	}
	
	public void parseFile() {
		int lineCount = 0;
		while(readFile.hasNext()) {
			lineCount++;
			parseLine(readFile.nextLine(), lineCount);
		}
		errorHandler();
	}
	
	public void errorHandler() {
		int errorCount = 0;
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				errorQ.enqueue(stack.pop());
			}
		}
		while(!errorQ.isEmpty() || !extrasQ.isEmpty()) {
			errorCount++;
			if(errorQ.isEmpty() && !extrasQ.isEmpty()) {
				System.out.println("Error, extra " + extrasQ.dequeue());
			} 
			else if(!errorQ.isEmpty() && extrasQ.isEmpty()) {
				System.out.println("Error with " + errorQ.dequeue());
			}
			else if (!errorQ.isEmpty() && !extrasQ.isEmpty()) {
				if(errorQ.peek().equals(extrasQ.peek())){
					extrasQ.dequeue();
					errorQ.dequeue();
				}
				else {
					System.out.println("Error with " + errorQ.dequeue());
				}
			}
		}
		if(errorCount == 0) {
			System.out.println("No Errors Found");
		}
	}
	
	public void parseLine(String line, int lineCount) {
		int openCount = 0;
		int closeCount = 0;
		String tagName = "null";
		String tag = "null";
		line = line.trim();
		//while the line has tags
		while(line.contains(">") && line.contains("<")) {
			tag = line.substring(line.indexOf('<'), line.indexOf('>')+1);
			line = line.substring(line.indexOf('>')+1);
			//if the tag has a ? or is self closing, ignore it
			if(!(tag.contains("?") || tag.contains("/>"))) {
				//if the tag has a space in it, substring the name to the space
				if(!tag.contains(" ")) {
					tagName = tag.substring(tag.indexOf('<') + 1, tag.indexOf('>'));
				}
				else {
					tagName = tag.substring(tag.indexOf('<') + 1, tag.indexOf(' '));
				}
				
				//System.out.println("Tag: " + tag);
				//System.out.println("Tag Name: " + tagName);
				
				//if tagName is start 
				if(!tagName.contains("/")) {
					//System.out.println("Pushing tag");
					stack.push(tagName);
				}
				else {
					//System.out.println("Closing tag");
					tagName = tagName.substring(tag.indexOf('/'));
						if(!stack.isEmpty() && tagName.equals(stack.peek())) {
							stack.pop();
						} 
						else if(!errorQ.isEmpty() && tagName.equals(errorQ.peek())) {
							errorQ.dequeue();
						} 
						else if(stack.isEmpty()) {
							errorQ.enqueue(tagName);
						}
						else {
							if(!stack.isEmpty()) {
								if(stack.search(tagName) > 0) {
									for(int i = 0; i<stack.search(tagName);i++) {
										errorQ.enqueue(stack.pop());
									}
									//System.out.println("Error with " + tagName);
								} 
								else {
									extrasQ.enqueue(tagName);
								}
							}
						}
				}
			} else {
				//System.out.println("Ignoring tag");
			}
		}
	}
}
