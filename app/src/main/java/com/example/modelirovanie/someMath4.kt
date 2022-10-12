package com.example.modelirovanie

import com.jjoe64.graphview.series.DataPoint

val ht4=0.1
val hx4=1
val mu4=1
val u4=-0.5
val sig=0.5
val T4=1
val     L4=100
val T01=80
val T02=90
val gam= doubleArrayOf(-0.5,0.5)
val muta= mutableListOf(0, 10, 25, 50, 75, 100)

fun math4( lt:Int):Array<Double>{
    var result=Array<Double>(L4){0.0}
    var A=Array<Double>(L4){0.0}
    var B=Array<Double>(L4){0.0}
    var C=Array<Double>(L4){0.0}
    var F=Array<Double>(L4){0.0}
    var a=Array<Double>(L4){0.0}
    var b=Array<Double>(L4){0.0}
    for(i in 0 until L4-1){
        if(i in T01..T02){
            result[i]=T4.toDouble()
        }else{
            result[i]=0.0
        }
    }
    var time=0.0
    B[0] = (mu4/(hx4*hx4)-u4/(2*hx4))*sig
    C[0] = 1/(2*ht4)+(mu4/(hx4*hx4)-u4/(2*hx4)+(mu4*gam[1])/hx4)*sig
    F[0] = result[0]*(1/(2*ht4)-(mu4/(hx4*hx4)-u4/(2*hx4)+(mu4*gam[1])/hx4)*(1-sig))+result[1]*(mu4/(hx4*hx4)-u4/(2*hx4))*(1-sig)-(mu4*gam[0])/hx4
    while (time<lt){
        for(i in 1..L-2){
            A[i] = (mu4/(hx4*hx4)+u4/(2*hx4))*sig
            B[i] = (mu4/(hx4*hx4)-u4/(2*hx4))*sig
            C[i] = 1/ht4 + (2*mu4/(hx4*hx4))*sig
            F[i] = result[i]*(1/ht4-(2*mu4/(hx4*hx4))*(1-sig))+result[i+1]*((mu4/(hx4*hx4)-u4/(2*hx4))*(1-sig))+result[i-1]*((mu4/(hx4*hx4)+u4/(2*hx4))*(1-sig))
            for(i in 0 until L-1) {
                a[i + 1] = B[i ] / (C[i] - a[i ] * A[i ])
                b[i + 1] = (F[i ] + A[i] * b[i ]) / (C[i ] - a[i ] * A[i ])
            }
        }

        time+=ht4.toDouble()
        result[0]=0.5;
        result[L4-1]=0.5*Math.sin((3.14*time)/50)
        var i=L4-2;
        while(i>0){
            result[i]=a[i+1]*result[i+1]+b[i+1]
            i--
        }
    }
    return result;
}
fun starter4():MutableList<Array<DataPoint>>{


    var mutableListOfArray= mutableListOf<Array<DataPoint>>()
    val x= linspace(0,L4.toDouble(),(L4/hx4))
    for(elem in muta){
        val result= math4(elem)
        var lastList= mutableListOf<DataPoint>()
        for(i in result.indices){
            lastList.add(DataPoint(x[i],result[i]))
        }
        lastList.sortBy { it->it.x }
        mutableListOfArray.add(lastList.toTypedArray())
    }
    return mutableListOfArray
}