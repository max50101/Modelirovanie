package com.example.modelirovanie

import com.jjoe64.graphview.series.DataPoint

var ht = 0.1
var hx = 1
var a = 1
var Tq = 100
var L = 100
fun scheme( lt:Double):Array<Double>{
    var y1=Array<Double>(Tq){0.0}
    var y2=Array<Double>(Tq){0.0}
    for(n in 0 until Tq-1){
        if(n in 39..51){
            y1[n]=L.toDouble()
        }else{
            y1[n]=0.0
        }
    }
    var check=0.0
    while(check<lt){
        for(i in 1 until L-2){
             y2[i]=y1[i]+ht*a*(y1[i+1]-2*y1[i]+y1[i-1])/(hx*hx)
        }
        check+=ht
        y1=y2
    }
    return y1
}

fun starter():MutableList<Array<DataPoint>>{
    val listResult= mutableListOf<Array<DataPoint>>()
    var y1= scheme(0.0)
    var y2= scheme(10.0)
    var y3= scheme(25.0)
    var y4= scheme(50.0)
    var y5= scheme(75.0)
    var y6= scheme(100.0)
    var xp= linspace(0,L.toDouble(),(L/hx).toInt())
    var lastList= mutableListOf<DataPoint>()
    for(i in y1.indices){
        lastList.add(DataPoint(xp[i],y1[i]))
    }
    lastList.sortBy { it->it.x }
    listResult.add(lastList.toTypedArray())
    lastList= mutableListOf<DataPoint>()
    for(i in y2.indices){
        lastList.add(DataPoint(xp[i],y2[i]))
    }
    lastList.sortBy { it->it.x }
    listResult.add(lastList.toTypedArray())
    lastList= mutableListOf<DataPoint>()
    for(i in y3.indices){
        lastList.add(DataPoint(xp[i],y3[i]))
    }
    lastList.sortBy { it->it.x }
    listResult.add(lastList.toTypedArray())
    lastList= mutableListOf<DataPoint>()
    for(i in y4.indices){
        lastList.add(DataPoint(xp[i],y4[i]))
    }
    lastList.sortBy { it->it.x }
    listResult.add(lastList.toTypedArray())
    lastList= mutableListOf<DataPoint>()
    for(i in y5.indices){
        lastList.add(DataPoint(xp[i],y5[i]))
    }
    lastList.sortBy { it->it.x }
    listResult.add(lastList.toTypedArray())
    lastList= mutableListOf<DataPoint>()
    for(i in y6.indices){
        lastList.add(DataPoint(xp[i],y6[i]))
    }
    lastList.sortBy { it->it.x }
    listResult.add(lastList.toTypedArray())
    return listResult

}