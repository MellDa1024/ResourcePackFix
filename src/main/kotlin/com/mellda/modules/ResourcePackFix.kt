package com.mellda.modules

import com.lambda.client.LambdaMod
import com.mellda.RPFPlugin
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import com.lambda.client.util.FolderUtils

/**
 * This is a module. First set properties then settings then add listener.
 * **/
internal object ResourcePackFix : PluginModule(
    name = "ResourcePackFix",
    category = Category.MISC,
    description = "Fixes Open ResourcePack Folder.",
    pluginMain = RPFPlugin
) {
    private val loginlog by setting("Log in Logger", true)

    @JvmStatic
    fun openFolder() {
        if (loginlog) LambdaMod.LOG.info("[ResourcePackFix] Replacing open method to FolderUtils...")
        FolderUtils.openFolder(FolderUtils.minecraftFolder + "\\resourcepacks")
    }
    //MixinGuiScreenResourcePacks
}