package com.example.morningclass.countrybook_fragment


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val gridLayout = activity!!.findViewById<GridLayout>(R.id.country_grid)
        //grid -> Index

        for (i in 0 until gridLayout.childCount){
            val imageButton = gridLayout.getChildAt(i)
            imageButton.setOnClickListener { view ->

                //portrait?
                if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    // this is how to creat intent in Kotlin
                    intent.putExtra("name", imageButton.tag.toString())
                    startActivity(intent)

                }else {
                    //landscape mode?
                    //1. get ref of detail frag
                    val detailFrag = activity!!.supportFragmentManager.findFragmentById(R.id.activityMainLand2) as fragment_detail

                    //set UI for detail frag (call method in detail frag)
                    detailFrag.setDetails(imageButton.tag.toString())

                }
            }
        }
    }


}
