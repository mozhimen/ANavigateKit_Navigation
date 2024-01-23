package com.mozhimen.navigatek.navigation.test

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mozhimen.basick.elemk.androidx.fragment.bases.BaseFragmentVB
import com.mozhimen.basick.elemk.mos.MKey
import com.mozhimen.basick.lintk.optin.OptInApiCall_BindLifecycle
import com.mozhimen.basick.lintk.optin.OptInApiInit_ByLazy
import com.mozhimen.navigatek.navigation.helpers.getDestinationId
import com.mozhimen.navigatek.navigation.test.databinding.FragmentThirdBinding
import com.mozhimen.navigatek.navigation.test.databinding.ItemNavigatekBinding
import com.mozhimen.uicorek.adapterk.quick.AdapterKQuickRecyclerVB

class ForthFragment : BaseFragmentVB<FragmentThirdBinding>() {
    private val _datas = mutableListOf(MKey("01", "01"))
    private var _adapter: AdapterKQuickRecyclerVB<MKey, ItemNavigatekBinding>? = null

    @OptIn(OptInApiCall_BindLifecycle::class, OptInApiInit_ByLazy::class)
    override fun initView(savedInstanceState: Bundle?) {
        arguments?.getString(FirstFragment.KEY_FIRST,"这是原有的数据")?.let {
            vb.navigatekFragmentSecondTxt1.text = it
        }
        vb.navigatekFragmentSecondTxt2.setOnClickListener {
            (parentFragment?.parentFragment as? SecondFragment)?.navigateKProxy?.startDestinationId(ThirdFragment::class.java.getDestinationId())
        }

        ///////////////////////////////////////////////////////////////////////

        vb.navigatekFragmentSecondRecycler.layoutManager = LinearLayoutManager(requireActivity())
        _adapter = AdapterKQuickRecyclerVB<MKey, ItemNavigatekBinding>(_datas, R.layout.item_navigatek, BR.item_navigatek)
        vb.navigatekFragmentSecondRecycler.adapter = _adapter
    }
}