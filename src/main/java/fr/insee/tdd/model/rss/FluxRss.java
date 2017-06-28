package fr.insee.tdd.model.rss;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@SuppressWarnings("serial")
@XmlRootElement(name = "rss")
public class FluxRss implements Serializable {

	private String version = "2.0";
	private Channel channel;
	private Long id;

	@XmlElement
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@XmlAttribute
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlTransient
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("title", channel.getTitle()).toString();
	}

}
