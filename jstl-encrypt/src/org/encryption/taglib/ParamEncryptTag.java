package org.encryption.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;

import org.apache.taglibs.standard.resources.Resources;
import org.apache.taglibs.standard.tag.common.core.ParamParent;
import org.apache.taglibs.standard.tag.common.core.ParamSupport;
import org.apache.taglibs.standard.tag.common.core.Util;
import org.encryption.encrypt.EncryptionUtility;

public class ParamEncryptTag extends ParamSupport {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1847497906674441972L;

	@Override
	public int doEndTag() throws JspException {
		
		
		
		 Tag localTag = findAncestorWithClass(this, ParamParent.class);
		    if (localTag == null) {
		      throw new JspTagException(Resources.getMessage("PARAM_OUTSIDE_PARENT"));
		    }
		    if ((this.name == null) || (this.name.equals(""))) {
		      return 6;
		    }
		    ParamParent localParamParent = (ParamParent)localTag;
		    String str1 = this.value;
		    if (str1 == null) {
		      if ((this.bodyContent == null) || (this.bodyContent.getString() == null)) {
		        str1 = "";
		      } else {
		        str1 = EncryptionUtility.encryptText(this.bodyContent.getString().trim());
		      }
		    }
		    if (this.encode)
		    {
		      String str2 = this.pageContext.getResponse().getCharacterEncoding();
		      localParamParent.addParameter(Util.URLEncode(this.name, str2), Util.URLEncode(str1, str2));
		    }
		    else
		    {
		      localParamParent.addParameter(this.name, str1);
		    }
		    return 6;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}


	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}

	

}
