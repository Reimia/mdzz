package com.reimia.xstreamTest2

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamAsAttribute
import com.thoughtworks.xstream.annotations.XStreamConverter
import com.thoughtworks.xstream.annotations.XStreamImplicit
import com.thoughtworks.xstream.converters.Converter
import com.thoughtworks.xstream.converters.MarshallingContext
import com.thoughtworks.xstream.converters.UnmarshallingContext
import com.thoughtworks.xstream.io.HierarchicalStreamReader
import com.thoughtworks.xstream.io.HierarchicalStreamWriter

/**
 * @author zsy
 */
@XStreamAlias("channel")
data class ZjIotChannelInfoBean(
	@XStreamAsAttribute
	var id: String,

	@XStreamAsAttribute
	var autoStart: String,

	@XStreamAsAttribute
	var timeout: String,

	@XStreamAsAttribute
	var description: String,

	val threadPool: ThreadPool?,

	@XStreamImplicit(itemFieldName = "header")
	val header: MutableList<Header>?,

	@XStreamImplicit(itemFieldName = "inAdaptor")
	val inAdaptor: MutableList<InAdaptor>?,

	@XStreamImplicit(itemFieldName = "outAdaptor")
	val outAdaptor: MutableList<OutAdaptor>?,

	@XStreamImplicit(itemFieldName = "bidirectionalAdaptor")
	val bidirectionalAdaptor: MutableList<BidirectionalAdaptor>?

) {
	constructor():this("","","","",null,null,null,null,null)

	data class ThreadPool(
		@XStreamImplicit(itemFieldName = "property")
		val property: MutableList<Property>?
	){
		constructor():this(mutableListOf())
	}

	data class Header(
		@XStreamImplicit(itemFieldName = "property")
		val property: MutableList<Property>?,

		@XStreamAsAttribute
		var id: String? = "",

		@XStreamAsAttribute
		var caption: String? = "",

		@XStreamAlias("class")
		@XStreamAsAttribute
		var clazz: String? = "",

		@XStreamAsAttribute
		var ctrlName: String? = ""
	){
		constructor():this(mutableListOf(),"","","","")
	}

	data class InAdaptor(
		@XStreamImplicit(itemFieldName = "property")
		val property: MutableList<Property>? = mutableListOf(),

		@XStreamAsAttribute
		var id: String? = "",

		@XStreamAsAttribute
		var caption: String? = "",

		@XStreamAlias("class")
		@XStreamAsAttribute
		var clazz: String? = "",

		@XStreamAsAttribute
		var ctrlName: String? = ""
	){
		constructor():this(mutableListOf(),"","","","")
	}

	data class OutAdaptor(
		@XStreamImplicit(itemFieldName = "property")
		val property: MutableList<Property>? = mutableListOf(),
		@XStreamAsAttribute
		var id: String? = "",

		@XStreamAsAttribute
		var caption: String? = "",

		@XStreamAlias("class")
		@XStreamAsAttribute
		var clazz: String? = "",

		@XStreamAsAttribute
		var ctrlName: String? = ""
	){
		constructor():this(mutableListOf(),"","","","")
	}

	data class BidirectionalAdaptor(
		@XStreamImplicit(itemFieldName = "property")
		val property: MutableList<Property>? = mutableListOf(),

		@XStreamAsAttribute
		var id: String? = "",

		@XStreamAsAttribute
		var caption: String? = "",

		@XStreamAlias("class")
		@XStreamAsAttribute
		var clazz: String? = "",

		@XStreamAsAttribute
		var ctrlName: String? = ""
	){
		constructor():this(mutableListOf(),"","","","")
	}

	@XStreamAlias("property")
	@XStreamConverter(ChannelInfoConverter::class)
	class Property(
			var name: String?,
			var value: String?
	){
		constructor():this("","")
	}

	class ChannelInfoConverter : Converter {
		override fun marshal(source: Any?, writer: HierarchicalStreamWriter?, context: MarshallingContext?) {
			val property = source as Property
			writer?.addAttribute("name", property.name)
			writer?.setValue(property.value)
		}

		override fun unmarshal(reader: HierarchicalStreamReader?, context: UnmarshallingContext?): Property? {
			val property: Property? = Property("","")
			property?.name = reader?.getAttribute("name")
			property?.value = reader?.value
			return property
		}

		override fun canConvert(type: Class<*>?): Boolean {
			if (type != null) {
				return type.equals(Property::class.java)
			}
			return false
		}

	}

}