package com.example.modelirovanie.Fragments

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.modelirovanie.R
import com.example.modelirovanie.starter
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class LabaratonayaThreeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frament_labaratornaya_three, container, false)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val graphView=getView()!!.findViewById<GraphView>(R.id.graphView)
        var gridLabel = graphView.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "x"
        gridLabel.verticalAxisTitle="y"
        graphView.viewport.isScrollable=true
        graphView.viewport.isScalable=true
        val bt=getView()!!.findViewById<Button>(R.id.button)
        bt.setOnClickListener{
            val graphSeriesList= starter()
            for(i in graphSeriesList.indices){
                val lineGraphSeries=LineGraphSeries<DataPoint>(graphSeriesList[i])
                when(i){
                    0->lineGraphSeries.color=Color.GREEN
                    1->lineGraphSeries.color=Color.RED
                    2->lineGraphSeries.color=Color.BLUE
                    3->lineGraphSeries.color=Color.YELLOW
                    4->lineGraphSeries.color=Color.MAGENTA
                    5->lineGraphSeries.color=Color.BLACK
                    else->Color.WHITE
                }
                lineGraphSeries.setOnDataPointTapListener { series, dataPoint ->
                    val msg="X: "+dataPoint.x+"\nY: "+ String.format("%.6f",dataPoint.y)
                    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()}
                graphView.addSeries(lineGraphSeries)
            }
        }
    }
}
