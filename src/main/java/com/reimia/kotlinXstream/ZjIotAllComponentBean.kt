package com.reimia.kotlinXstream

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamAsAttribute
import com.thoughtworks.xstream.annotations.XStreamImplicit

@XStreamAlias("root")
data class ZjIotAllComponentBean(
        @XStreamImplicit(itemFieldName = "group")
        val groups: MutableList<ZjIotGroupBean>
) {
    @XStreamAlias("group")
    data class ZjIotGroupBean(
            @XStreamAsAttribute
            var name: String,

            @XStreamImplicit(itemFieldName = "control")
            var controls: MutableList<ZjIotComponentBean>,

            @XStreamImplicit(itemFieldName = "header")
            var headers: MutableList<ZjIotComponentBean>,

            @XStreamImplicit(itemFieldName = "inAdaptor")
            var inAdaptors: MutableList<ZjIotComponentBean>,

            @XStreamImplicit(itemFieldName = "outAdaptor")
            var outAdaptors: MutableList<ZjIotComponentBean>,

            @XStreamImplicit(itemFieldName = "bidirectionalAdaptor")
            var bidirectionalAdaptors: MutableList<ZjIotComponentBean>

    ) {
        data class ZjIotComponentBean(
                @XStreamAsAttribute
                var caption: String,

                @XStreamAsAttribute
                var type: String,

                @XStreamAsAttribute
                @XStreamAlias("class")
                val clazz: String,

                @XStreamAsAttribute
                @XStreamAlias("resource-id")
                var resourceId: String,

                @XStreamAlias("specialAttributes")
                var specialAttributes: ZjIotSpecialAttributesBean,

                @XStreamImplicit(itemFieldName = "exit")
                @XStreamAlias("exit")
                var exits: MutableList<ZjIotExitBean>,

                @XStreamAlias("description")
                var description: String
        ) {
            data class ZjIotSpecialAttributesBean(

                    @XStreamImplicit(itemFieldName = "specAttribute")
                    @XStreamAlias("specAttribute")
                    var specAttribute: MutableList<ZjIotSpecAttributeBean>
            ) {
                data class ZjIotSpecAttributeBean(
                        @XStreamAsAttribute
                        var name: String,

                        @XStreamAsAttribute
                        var type: String,

                        @XStreamAsAttribute
                        var value: String,

                        @XStreamAsAttribute
                        var description: String
                )
            }

            data class ZjIotExitBean(
                    @XStreamAsAttribute
                    var result: String,

                    @XStreamAsAttribute
                    var description: String)
        }


    }
}