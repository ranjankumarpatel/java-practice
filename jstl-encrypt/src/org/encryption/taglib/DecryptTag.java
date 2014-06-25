package org.encryption.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.encryption.encrypt.EncryptionUtility;

public class DecryptTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3033779055703904010L;

	private String value;
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		 try {
	            JspWriter out = pageContext.getOut();	            
	            out.print(EncryptionUtility.decryptText(value));
	            
	        } catch(IOException ioe) {
	            throw new JspException("Error: " + ioe.getMessage());
	        }       
		 
		 return SKIP_BODY;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	

	

}
