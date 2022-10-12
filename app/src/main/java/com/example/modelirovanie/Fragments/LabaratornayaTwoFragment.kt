package com.example.modelirovanie.Fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.modelirovanie.*
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class LabaratornayTwoFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_labaratonaya_two,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val graphView=getView()!!.findViewById<GraphView>(R.id.graphView1)
        val graphView2=getView()!!.findViewById<GraphView>(R.id.graphView2)
        val graphView3=getView()!!.findViewById<GraphView>(R.id.graphView3)
        val graphView4=getView()!!.findViewById<GraphView>(R.id.graphView4)
        val lineGraphSeries1=LineGraphSeries<DataPoint>(initiateHeavySideGraph())
        lineGraphSeries1.isDrawDataPoints=true
        var gridLabel = graphView.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "x"
        gridLabel.verticalAxisTitle="y"
        gridLabel=graphView2.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "x"
        gridLabel.verticalAxisTitle="y"
        gridLabel=graphView3.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "x"
        gridLabel.verticalAxisTitle="y"
        gridLabel=graphView4.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "x"
        gridLabel.verticalAxisTitle="y"
//        graphView.viewport.isScrollable=true
//        graphView.viewport.isScalable=true
//        graphView2.viewport.isScrollable=true
//        graphView2.viewport.isScalable=true
//        graphView3.viewport.isScrollable=true
//        graphView3.viewport.isScalable=true
//        graphView4.viewport.isScrollable=true
//        graphView4.viewport.isScalable=true
        lineGraphSeries1.setOnDataPointTapListener { series, dataPoint ->
            val msg="X: "+dataPoint.x+"\nY: "+ String.format("%.6f",dataPoint.y)
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()}
        graphView.addSeries(lineGraphSeries1)
        graphView2.addSeries(lineGraphSeries1)
        graphView3.addSeries(lineGraphSeries1)
        graphView4.addSeries(lineGraphSeries1)
        graphView3.addSeries(LineGraphSeries<DataPoint>(initiateLeftSideGraph()))
        graphView.addSeries(LineGraphSeries<DataPoint>(initiateCentral()))
        graphView4.addSeries(LineGraphSeries<DataPoint>(initiateCabaret()))
        graphView2.addSeries(LineGraphSeries<DataPoint>(initiateCentralCabaret()))

    }


    fun initiateHeavySideGraph():Array<DataPoint>{
        val p= HeavySide()
        var lastList= mutableListOf<DataPoint>()
        for( i in 0..p.first.size-1){
            lastList.add(DataPoint(p.second[i],p.first[i]))
        }
        lastList.sortBy { it->it.x }
        return lastList.toTypedArray()
    }
    fun initiateLeftSideGraph():Array<DataPoint>{
        val p= left_Scheme()
        var lastList= mutableListOf<DataPoint>()
        for( i in 0 until p.first.size){
            lastList.add(DataPoint(p.second[i],p.first[i]))
        }
        lastList.sortBy { it->it.x }
        return lastList.toTypedArray()
    }
    fun initiateCentral():Array<DataPoint>{
        val p= centralScheme()
        var lastList= mutableListOf<DataPoint>()
        for( i in 0 until p.first.size){
            lastList.add(DataPoint(p.second[i],p.first[i]))
        }
        lastList.sortBy { it->it.x }
        return lastList.toTypedArray()
    }
    fun initiateCabaret():Array<DataPoint>{
        val p= cabaret()
        var lastList= mutableListOf<DataPoint>()
        for( i in 0 until p.first.size){
            lastList.add(DataPoint(p.second[i],p.first[i]))
        }
        lastList.sortBy { it->it.x }
        return lastList.toTypedArray()
    }
    fun initiateCentralCabaret():Array<DataPoint>{
        val p= centralCabaret()
        var lastList= mutableListOf<DataPoint>()
        for( i in 0 until p.first.size){
            lastList.add(DataPoint(p.second[i],p.first[i]))
        }
        lastList.sortBy { it->it.x }
        return lastList.toTypedArray()
    }
}