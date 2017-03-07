package net.viralpatel.struts2.helper;

import java.io.IOException;

import org.markdown4j.Markdown4jProcessor;

public class MarkdownHelper {

	private static MarkdownHelper markdownHelper;
	
	private Markdown4jProcessor markdown4jProcessor;
	
	public static MarkdownHelper getInstance() {
		
		if (markdownHelper != null && markdownHelper instanceof MarkdownHelper) {
			return markdownHelper;
		} else {
			markdownHelper = new MarkdownHelper();
			return markdownHelper;
		}
		
	}
	
	public MarkdownHelper() {
		
		this.setMarkdown4jProcessor(new Markdown4jProcessor());
		
	}
	
	public String purify(String html) throws IOException {
		
		return getMarkdown4jProcessor().process(html);
		
	}
	
	public void setMarkdown4jProcessor(Markdown4jProcessor markdownHelper) {
		
		this.markdown4jProcessor = markdownHelper;
		
	}
	
	public Markdown4jProcessor getMarkdown4jProcessor() {
		
		return markdown4jProcessor;
		
	}
	
}
