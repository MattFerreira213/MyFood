package com.example.myfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfood.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.contracts.Returns

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        steupViews()
    }

    private fun steupViews() {
        val tableLayout = binding.addTab
        val viewPage = binding.addViewpager
        val adapter = TabViewPagerAdapter(this)
        viewPage.adapter = adapter

        TabLayoutMediator(tableLayout, viewPage) { tab, position ->
            tab.text = getString(adapter.tabs[position])

        }.attach()
    }

    class TabViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        val tabs = arrayOf(R.string.restaurants, R.string.marketplaces, R.string.drinks)
        val fragments = arrayOf(MarketplaceFragment(), MarketplaceFragment(), MarketplaceFragment())
        override fun getItemCount() = fragments.size

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }

    class MarketplaceFragment : Fragment() {}
}