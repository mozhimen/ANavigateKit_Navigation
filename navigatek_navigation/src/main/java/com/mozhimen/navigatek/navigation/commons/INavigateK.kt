package com.mozhimen.navigatek.navigation.commons

import androidx.navigation.NavController
import com.mozhimen.navigatek.navigation.mos.MNavigateKConfig


/**
 * @ClassName INavigateK
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/26 13:17
 * @Version 1.0
 */
interface INavigateK {
    fun setNavigateKConfig(config: MNavigateKConfig): INavigateK
    fun setupNavGraph(containerId: Int, clazzes: List<Class<*>>, defaultDestinationId: Int = 0): NavController
}