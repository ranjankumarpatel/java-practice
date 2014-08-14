package org.encryption.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.encryption.encrypt.Encrypto;

public class EncryptTagSupport extends TagSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4869704497238114173L;


	public EncryptTagSupport() {
		// TODO Auto-generated constructor stub
	}
	
	private String value;
    
     
    @Override
    public int doStartTag() throws JspException {
         
        try {
            //Get the writer object for output.
            JspWriter out = pageContext.getOut();
 
            //Perform substr operation on string.
            out.println(Encrypto.encryptText(value));
 
        } catch (IOException e) {
            e.printStackTrace();
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
