package org.underwares.cyanure;
/* $Id: Configuration.java 1233 2010-06-12 04:48:30Z supernaut $
 *   ____
 *  / ___|   _  __ _ _ __  _   _ _ __ ___
 * | |  | | | |/ _` | '_ \| | | | '__/ _ \
 * | |__| |_| | (_| | | | | |_| | | |  __/
 *  \____\__, |\__,_|_| |_|\__,_|_|  \___|
 *       |___/
 *
 * Multi Purpose Artificial Inelegance Program
 * Copyright (c) Alexandre Gauthier 2010-2011
 * All Rights Reserved
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 * Exception thrown when network-bound server fails in a critical way.
 * 
 * @author Alexandre Gauthier
 */
public class ShellServerErrorException extends Exception {

    /**
     * Creates a new instance of <code>ShellServerErrorException</code> without detail message.
     */
    public ShellServerErrorException() {
    }


    /**
     * Constructs an instance of <code>ShellServerErrorException</code> with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public ShellServerErrorException(String msg) {
        super(msg);
    }
}
