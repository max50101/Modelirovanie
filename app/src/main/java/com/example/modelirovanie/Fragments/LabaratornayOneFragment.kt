package com.example.modelirovanie.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.modelirovanie.R
import com.example.modelirovanie.eyler
import com.example.modelirovanie.rangekut2
import com.example.modelirovanie.rangekut4
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class LabaratornayOneFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_labaratornaya_one,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val but = getView()!!.findViewById<Button>(R.id.eylerBtn)
        val but2 = getView()!!.findViewById<Button>(R.id.Rudekut)
        val but3 = getView()!!.findViewById<Button>(R.id.Rudekut2)
        val edText= getView()?.findViewById<EditText>(R.id.editTextTextT)
        val edTextN=getView()?.findViewById<EditText>(R.id.editTextText2)
        but.setOnClickListener{
            val graphView=getView()!!.findViewById<GraphView>(R.id.graphView)
            val lineGraphSeries= LineGraphSeries<DataPoint>(initiateEyler(edText?.text.toString().toInt(),edTextN?.text.toString().toInt() as Int))
            lineGraphSeries.isDrawDataPoints=true
            val gridLabel = graphView.gridLabelRenderer
            gridLabel.horizontalAxisTitle = "t"
            gridLabel.verticalAxisTitle="y"
            graphView.viewport.isScrollable=true
            graphView.viewport.isScalable=true
            lineGraphSeries.setOnDataPointTapListener { series, dataPoint ->
                val msg="X: "+dataPoint.x+"\nY: "+ String.format("%.6f",dataPoint.y)
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()}
            graphView.addSeries(lineGraphSeries)
        }

        but2.setOnClickListener{
            val graphView=getView()!!.findViewById<GraphView>(R.id.graphView)
            val lineGraphSeries= LineGraphSeries<DataPoint>(initiateRangekut2(edText?.text.toString().toInt(),edTextN?.text.toString().toInt() as Int))
            lineGraphSeries.isDrawDataPoints=true
            val gridLabel = graphView.gridLabelRenderer
            gridLabel.horizontalAxisTitle = "t"
            gridLabel.verticalAxisTitle="y"
            graphView.viewport.isScrollable=true
            graphView.viewport.isScalable=true
            lineGraphSeries.setOnDataPointTapListener { series, dataPoint ->
                val msg="X: "+dataPoint.x+"\nY: "+ String.format("%.6f",dataPoint.y)
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()}
            graphView.addSeries(lineGraphSeries)
        }
        but3.setOnClickListener{
            val graphView=getView()!!.findViewById<GraphView>(R.id.graphView)
            val lineGraphSeries= LineGraphSeries<DataPoint>(initiateRangekut4(edText?.text.toString().toInt(),edTextN?.text.toString().toInt() as Int))
            lineGraphSeries.isDrawDataPoints=true
            val gridLabel = graphView.gridLabelRenderer
            gridLabel.horizontalAxisTitle = "t"
            gridLabel.verticalAxisTitle="y"
            graphView.viewport.isScrollable=true
            graphView.viewport.isScalable=true
            lineGraphSeries.setOnDataPointTapListener { series, dataPoint ->
                val msg="X: "+dataPoint.x+"\nY: "+ String.format("%.6f",dataPoint.y)
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()}
            graphView.addSeries(lineGraphSeries)
        }

    }
    fun initiateEyler(T:Int,N:Int):Array<DataPoint>{
        val map= eyler(T.toDouble(),N)
        var list= mutableListOf<Pair<Double,Double>>()
        map.forEach{
            list.add(Pair(it.key,it.value))
        }

        var lastList= mutableListOf<DataPoint>()
        list.forEach{
            lastList.add(DataPoint(it.first,it.second))
        }

        return lastList.toTypedArray()
    }
    fun initiateRangekut2(T:Int,N:Int):Array<DataPoint>{
        val map= rangekut2(T.toDouble(),N)
        var list= mutableListOf<Pair<Double,Double>>()
        map.forEach{
            list.add(Pair(it.key,it.value))
        }

        var lastList= mutableListOf<DataPoint>()
        list.forEach{
            lastList.add(DataPoint(it.first,it.second))
        }

        return lastList.toTypedArray()
    }
    fun initiateRangekut4(T:Int,N:Int):Array<DataPoint>{
        val map= rangekut4(T.toDouble(),N)
        var list= mutableListOf<Pair<Double,Double>>()
        map.forEach{
            list.add(Pair(it.key,it.value))
        }

        var lastList= mutableListOf<DataPoint>()
        list.forEach{
            lastList.add(DataPoint(it.first,it.second))
        }

        return lastList.toTypedArray()
    }
}