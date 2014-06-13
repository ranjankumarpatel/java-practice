package customtag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TodayTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3033779055703904010L;

	private String format;
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		 try {
	            JspWriter out = pageContext.getOut();
	            Date today = new Date();
	            SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
	            out.print(dateFormatter.format(today));
	            
	        } catch(IOException ioe) {
	            throw new JspException("Error: " + ioe.getMessage());
	        }       
		 
		 return SKIP_BODY;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	

}
