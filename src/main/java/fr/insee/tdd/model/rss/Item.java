package fr.insee.tdd.model.rss;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URL;
import java.util.Date;

@XmlType(name = "item", propOrder = { "title", "link", "description", "category", "pubDate", "guid" })
public class Item {

	private String title, description, category;
	private URL link;
	private Date pubDate;
	private URL guid;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("title", title)
			.add("link", link)
			.add("pubDate", pubDate)
			.add("guid", guid).toString();
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public URL getLink() {
		return link;
	}

	public void setLink(URL link) {
		this.link = link;
	}

	@XmlElement
	@XmlJavaTypeAdapter(value = DatePublicationAdapter.class)
	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@XmlElement
	public URL getGuid() {
		return guid;
	}

	public void setGuid(URL guid) {
		this.guid = guid;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
