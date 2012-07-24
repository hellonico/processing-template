/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package template.library;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

import processing.core.PApplet;

/**
 * This is a template class and can be used to start a new processing library or
 * tool. Make sure you rename this class as well as the name of the example
 * package 'template' to your own library or tool naming convention.
 * 
 * @example Hello
 * 
 *          (the tag @example followed by the name of an example included in
 *          folder 'examples' will automatically include the example in the
 *          javadoc.)
 * 
 */

public class HelloLibrary {

	PApplet myParent;

	Method fancyEventMethod;


	int myVariable = 0;

	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	public HelloLibrary(PApplet theParent) {
		myParent = theParent;
		welcome();
		
		myParent.registerMouseEvent(this);

		// your library init code here...

		
		// check to see if the host applet implements
		// public void fancyEvent(FancyLibrary f)
		try {
			fancyEventMethod = theParent.getClass().getMethod("fancyEvent",
					new Class[] { HelloLibrary.class });
		} catch (Exception e) {
			// no such method, or an error.. which is fine, just ignore
		}
	}

	private void welcome() {
		System.out
				.println("##library.name## ##library.prettyVersion## by ##author##");
	}

	public String sayHello() {
		makeEvent();
		return "hello library.";
	}

	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	/**
	 * 
	 * @param theA
	 *            the width of test
	 * @param theB
	 *            the height of test
	 */
	public void setVariable(int theA, int theB) {
		myVariable = theA + theB;
	}

	/**
	 * 
	 * @return int
	 */
	public int getVariable() {
		return myVariable;
	}

	// then later, to fire that event
	public void makeEvent() {
		if (fancyEventMethod != null) {
			try {
				fancyEventMethod.invoke(myParent, new Object[] { this });
			} catch (Exception e) {
				System.err.println("Disabling fancyEvent() for because of an error.");
				e.printStackTrace();
				fancyEventMethod = null;
			}
		}
	}
	
	public void mouseEvent(MouseEvent event) {
		  int x = event.getX();
		  int y = event.getY();

		  switch (event.getID()) {
		    case MouseEvent.MOUSE_PRESSED:
		      System.out.println("hello mouse pressed");
		      // do something for the mouse being pressed
		      break;
		    case MouseEvent.MOUSE_RELEASED:
		      System.out.println("hello mouse released");
		      // do something for mouse released
		      break;
		    case MouseEvent.MOUSE_CLICKED:
		      System.out.println("hello mouse clicked");
		      // do something for mouse clicked
		      break;
		    case MouseEvent.MOUSE_DRAGGED:
		      System.out.println("hello mouse dragged");
		      // do something for mouse dragged
		      break;
		    case MouseEvent.MOUSE_MOVED:
		      System.out.println("hello mouse moved");
		      // umm... forgot
		      break;
		  }
		}
}
