package fr.insee.tdd.model.rss;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@XmlType(name = "channel", propOrder = { "title", "link", "description", "language", "copyright", "webMaster", "pubDate", "category", "image", "items" })
public class Channel implements Serializable {

	private String title, link, description, language, copyright, webMaster, category;
	private Date pubDate;
	private List<Item> items;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("title", title)
			.add("link", link)
			.add("description", description)
			.add("language", language)
			.add("pubDate", pubDate)
			.add("category", category)
			.add("items", items).toString();
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@XmlElement
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@XmlElement(name = "item", type = Item.class)
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@XmlElement
	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	@XmlElement
	public String getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}

}
