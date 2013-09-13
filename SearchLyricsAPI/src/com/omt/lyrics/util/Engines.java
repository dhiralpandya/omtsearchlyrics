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
package com.omt.lyrics.util;

/**
 * This enum contains information of all search engine that you can use to
 * search your lyrics.
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public enum Engines {

	GOOGLE(1, "google", "http", "www.google.com");
	// , YAHOO(2, "yahoo", "http",
	// "www.yahoo.com"), BING(3, "bing", "http", "www.bing.com");

	private int id = 0;
	private String name = "";
	private String protocol = "";
	private String host = "";

	private Engines(int id, String name, String protocol, String host) {
		this.id = id;
		this.name = name;
		this.protocol = protocol;
		this.host = host;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
