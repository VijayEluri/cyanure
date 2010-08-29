package org.underwares.cyanure.bridges;
/* $Id$
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
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jibble.pircbot.*;

import org.underwares.cyanure.ai.Soul;
import org.underwares.cyanure.Configuration;
import org.underwares.cyanure.Constants;
import org.underwares.cyanure.DaemonTaskManager;

/**
 *
 * @author supernaut
 */
public class InternetChatRelay extends PircBot{

    Soul soul;
    DaemonTaskManager taskmanager = DaemonTaskManager.getInstance();

    public InternetChatRelay(Soul soul){
        //TODO: Make this, well, not static.
        this.setName(Configuration.getAiname());
        this.soul = soul;
    }

    @Override
    public void onMessage(String channel, String sender,
            String login, String hostname, String message){
        
        String prefix = this.getNick() + ": ";

        if (message.toLowerCase().startsWith(prefix)) {
            String input = message.replaceFirst(prefix, "");

            if (input.equalsIgnoreCase("*time")) {
                String time = new java.util.Date().toString();
                sendMessage(channel, sender + ": Local time here is " + time);
            } else if (input.equalsIgnoreCase("*talk")) {
                sendMessage(channel, sender + ": " + soul.speak());
            } else if (input.equalsIgnoreCase("*save")) {
                sendMessage(channel, "## Saving soul...");
                try {
                    soul.save(Configuration.getBrainFile());
                } catch (FileNotFoundException ex) {
                    sendMessage(channel, "## ERROR: File not found.");
                } catch (IOException ex) {
                    sendMessage(channel, "## ERROR: Generic IO Exception.");
                } catch (Exception ex) {
                    sendMessage(channel, "## ERROR: Unhandled Exception. Check logs for details.");
                } finally {
                    sendMessage(channel, "## Done.");
                }
            } else if (input.equalsIgnoreCase("*version")) {
                sendMessage(channel, sender + ": Multi Purpose Artificial Inelegance Program" +
                                        " - Version " + Constants.VERSION +
                                        " - (c) Alexandre Gauthier <alex@underwares.org>");
                sendMessage(channel, sender + ": http://www.underwares.org/codex/projects/show/cyanure");
            } else if (input.equalsIgnoreCase("*tasks")) {
                sendMessage(channel, sender + ": " + taskmanager.toString());
            } else {
                sendMessage(channel, sender + ": " + soul.converse(input));
            }
        } else {
            soul.learn(message);
        }
    }
}
