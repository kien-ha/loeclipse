/*************************************************************************
 *
 * $RCSfile: Include.java,v $
 *
 * $Revision: 1.1 $
 *
 * last change: $Author: cedricbosdo $ $Date: 2005/08/10 12:07:22 $
 *
 * The Contents of this file are made available subject to the terms of
 * either of the following licenses
 *
 *     - GNU Lesser General Public License Version 2.1
 *     - Sun Industry Standards Source License Version 1.1
 *
 * Sun Microsystems Inc., October, 2000
 *
 *
 * GNU Lesser General Public License Version 2.1
 * =============================================
 * Copyright 2000 by Sun Microsystems, Inc.
 * 901 San Antonio Road, Palo Alto, CA 94303, USA
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA 02111-1307 USA
 *
 *
 * Sun Industry Standards Source License Version 1.1
 * =================================================
 * The contents of this file are subject to the Sun Industry Standards
 * Source License Version 1.1 (the "License"); You may not use this file
 * except in compliance with the License. You may obtain a copy of the
 * License at http://www.openoffice.org/license.html.
 *
 * Software provided under this License is provided on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING,
 * WITHOUT LIMITATION, WARRANTIES THAT THE SOFTWARE IS FREE OF DEFECTS,
 * MERCHANTABLE, FIT FOR A PARTICULAR PURPOSE, OR NON-INFRINGING.
 * See the License for the specific provisions governing your rights and
 * obligations concerning the Software.
 *
 * The Initial Developer of the Original Code is: Sun Microsystems, Inc..
 *
 * Copyright: 2002 by Sun Microsystems, Inc.
 *
 * All Rights Reserved.
 *
 * Contributor(s): Cedric Bosdonnat
 *
 *
 ************************************************************************/
package org.openoffice.ide.eclipse.model;

/**
 * This class represents an include line in an idl file. It has a name
 * and could be either local to the project or in a library (ie: in a
 * file pointed by the include path in idlc)
 * 
 * @author cbosdonnat
 *
 */
public class Include {

	private String name;
	
	private boolean library = false;
	
	public Include(String aName, boolean aLibrary) {
		setName(aName);
		setLibrary(aLibrary);
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isLibrary(){
		return library;
	}
	
	public void setName(String aName){
		name = aName;
	}
	
	public void setLibrary(boolean aLibrary){
		library = aLibrary;
	}

	/**
	 * Two includes are equals if they contains the same data, not only if they
	 * have the same reference.
	 */
	public boolean equals(Object arg0) {
		boolean equals = false;
		
		if (arg0 instanceof Include){
			Include other = (Include)arg0;
			
			if (getName().equals(other.getName()) && 
			 	isLibrary() == other.isLibrary()) {
				
				equals = true;
			}
		}
		return equals;
	}
	
	public String toString() {
		String openToken = "<";
		String closeToken = ">";
		
		if (!isLibrary()){
			openToken = "\"";
			closeToken = "\"";
		}
		
		return "#include " + openToken + getName() + closeToken + "\n";
	}
	
}
