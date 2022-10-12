package com.example.modelirovanie

import kotlin.math.cos
import kotlin.math.sin

fun mathing(y:Double,point:Double):Double{
    return y-cos(point)+ sin(2*point)
}
fun mathingRangekut(y:Double,point:Double,psi:Double):Double{
    return mathing(y,point)*psi+y
}

fun eyler(stopCondtion:Double,N:Int,):MutableMap<Double,Double>{
    val point=0.0
    val pointResult=2.0
    val psi:Double=stopCondtion/ N.toDouble()
    var tStart=point*psi
    val map= mutableMapOf<Double,Double>(tStart to pointResult)
    var iterator=0
    do{
        iterator++
        val mapKey=map.keys.last()
        val mapValue=map.values.last()
        val value = mapValue+psi*mathing(mapValue,mapKey)
        tStart=iterator*psi
        map.put(tStart,value)
    }while(iterator!=N)
    return map
}

fun rangekut2(stopCondtion:Double,N:Int):MutableMap<Double,Double>{
    val psi:Double=stopCondtion/N.toDouble()
    val point=0.0
    val pointResult=2.0
    var tStart=point*psi
    val map= mutableMapOf<Double,Double>(tStart to pointResult)
    var iterator=0
    do{
        iterator++
        val mapKey=map.keys.last()
        val mapValue=map.values.last()
        val value=((0.5)*mathing(mapValue,mapKey)+0.5*mathing( mathingRangekut(mapValue,mapKey,psi),mapKey+psi))*psi+mapValue
        tStart=iterator*psi
        map.put(tStart,value)
    }while(iterator!=N)
    return map
}

fun rangekut4(stopCondtion: Double,N: Int):MutableMap<Double,Double>{
    val psi:Double=stopCondtion/N.toDouble()
    val point=0.0
    val pointResult=2.0
    var tStart=point*psi
    val map= mutableMapOf<Double,Double>(tStart to pointResult)
    var iterator=0
    do{
        iterator++
        val mapKey=map.keys.last()
        val mapValue=map.values.last()
        val k1=mathing(mapValue,mapKey)
        val k2=mathing(mapValue+(psi*k1)/2,mapValue+psi/2)
        val k3=mathing(mapValue+(psi*k2)/2,mapValue+psi/2)
        val k4=mathing(mapValue+(psi*k3),mapValue+psi)
        val result=((k1+2*k2+2*k3+k4)*2)*psi+mapValue
        tStart=iterator*psi
        map.put(tStart,result )
    }while(iterator!=N)
    return map
}