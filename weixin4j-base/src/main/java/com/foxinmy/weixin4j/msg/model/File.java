package com.foxinmy.weixin4j.msg.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.type.MediaType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文件对象
 * <p>
 * <font color="red">可用于「企业号的客服消息」</font>
 * </p>
 * 
 * @className File
 * @author jy
 * @date 2014年11月21日
 * @since JDK 1.7
 * @see
 */
public class File extends Base implements Notifyable {
	private static final long serialVersionUID = -8149837316289636110L;

	/**
	 * 上传后的微信返回的媒体ID
	 */
	@JSONField(name = "media_id")
	@XStreamAlias("MediaId")
	private String mediaId;

	public File(String mediaId) {
		super(MediaType.file);
		this.mediaId = mediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		return "File [mediaId=" + mediaId + "]";
	}
}
