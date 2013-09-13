/**
   Copyright 2013 Dhiral Pandya

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.omt.lyrics.beans;

import com.omt.lyrics.util.Sites;

/**
 * This is main Lyrics bean. This bean return by all parsers and services as a
 * search result.
 * 
 * 
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class Lyrics {

	private String text = "";
	private Sites sites = null;
	private String link = "";

	/**
	 * It contains lyrics of song.
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set song lyrics.
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get Lyrics site link that contains current lyrics.
	 * 
	 * @return
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Set site link that contains current lyrics.
	 * 
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Get site that contains current lyrics
	 * 
	 * @return
	 */
	public Sites getSites() {
		return sites;
	}

	/**
	 * Set site that contains current lyrics
	 * 
	 * @param sites
	 */
	public void setSites(Sites sites) {
		this.sites = sites;
	}

}
