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

import com.omt.lyrics.util.Services;

/**
 * This bean is use to search lyrics using Services. <br/>
 * <b>Example</b> <br/>
 * SearchLyrics searchLyrics = new SearchLyrics();<br/>
 * <br/>
 * LyricsServiceBean bean = new LyricsServiceBean();<br/>
 * bean.setSongName("let her go"); <br/>
 * bean.setSongAlbum("passenger");<br/>
 * 
 * List<Lyrics> lyrics = searchLyrics.searchLyrics(bean);
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 11 Sep 2013
 * @version 1.0
 * 
 */
public class LyricsServiceBean {
	private String searchStartWith = "";
	private String songName = "";
	private String songArtist = "";
	private String songAlbum = "";
	private String searchEndWith = "";
	private Services services = Services.LYRICSWIKIA;

	/**
	 * Get Search start with
	 * 
	 * @return
	 */
	public String getSearchStartWith() {
		return searchStartWith;
	}

	/**
	 * Set search start with<br/>
	 * This param will use as a first string when api search lyrics for songs. <br>
	 * By default is it blank string.
	 * 
	 * @param searchStartWith
	 */
	public void setSearchStartWith(String searchStartWith) {
		this.searchStartWith = searchStartWith;
	}

	/**
	 * Get song name
	 * 
	 * @return
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * Set song name
	 * 
	 * @param songName
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * Get song artist
	 * 
	 * @return
	 */
	public String getSongArtist() {
		return songArtist;
	}

	/**
	 * Set song artist.
	 * 
	 * @param songArtist
	 */
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}

	/**
	 * Get album name
	 * 
	 * @return
	 */
	public String getSongAlbum() {
		return songAlbum;
	}

	/**
	 * Set album name
	 * 
	 * @param songAlbum
	 */
	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}

	/**
	 * Get search end with
	 * 
	 * @return
	 */
	public String getSearchEndWith() {
		return searchEndWith;
	}

	/**
	 * Set search end with<br/>
	 * This param will use as a last string when api search lyrics for songs. <br>
	 * By default is it blank string.
	 * 
	 * @param searchEndWith
	 */
	public void setSearchEndWith(String searchEndWith) {
		this.searchEndWith = searchEndWith;
	}

	/**
	 * Service that will use in search lyrics. {@link Services}
	 * 
	 * @return {@link Services}
	 */
	public Services getServices() {
		return services;
	}

	/**
	 * Which service you want to use for searching your lyrics. <br>
	 * See {@link Services}
	 * 
	 * @param services
	 *            {@link Services}
	 */
	public void setServices(Services services) {
		this.services = services;
	}
}
