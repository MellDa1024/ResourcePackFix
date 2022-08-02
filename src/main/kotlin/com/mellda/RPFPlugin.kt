package com.mellda

import com.lambda.client.plugin.api.Plugin
import com.mellda.modules.ResourcePackFix

internal object RPFPlugin : Plugin() {

    override fun onLoad() {
        modules.add(ResourcePackFix)
    }
}