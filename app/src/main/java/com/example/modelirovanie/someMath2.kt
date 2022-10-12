package com.example.modelirovanie
val tau = 0.1
val u = 0.5
val h = 1
val T = 10
val N = 40
fun linspace(start: Int, stop: Double, num: Int) = Array(num) { start + it * ((stop - start) / (num - 1)) }
fun func(x:Int):Int{
    if(x>=20){
        return 0
    }else{
        return 1
    }
}
fun HeavySide():Pair<Array<Double>,Array<Double>>{
    var N1=(N/tau).toInt()
    var t= linspace(0,N1*tau,N1+1)
    var y=Array<Double>(N1+1){0.0}
    for(n in 0 until N1){
        if(t[n]>20) y[n]=0.0
        else y[n]=1.0
    }
    return Pair(y,t)
}
fun left_Scheme(): Pair<Array<Double>, Array<Double>> {
    var y1=Array<Double>(N+1){0.0}
    var y2=Array<Double>(N+1){0.0}
    y2[0]=func(0).toDouble()
    var t= linspace(0,N.toDouble(),N+1)
    for(n in 0..(N-1)){
        y1[n]=func(n).toDouble()
    }
    var counter= 0.0
    while(counter<T){
        for(i in 1 until N+1) {
            counter+=tau
            y2[i]=y1[i]-tau*u*((y1[i]-y1[i-1])/h)
        }
        y1=y2
        counter+=tau
    }
    println()
    return Pair(y2,t)
}


fun centralScheme():Pair<Array<Double>,Array<Double>>{
    var y1=Array(N+2){0.0}
    var y2=Array(N+2){0.0}
    y2[0]=func(0).toDouble()
    var t= linspace(0,N.toDouble()+1,N+2)
    for(n in 0 until (N+1)){
        y1[n]=func(n).toDouble()
    }
    var counter=0.0
    while(counter<T){
        for(i in 1 until N+1) {
            y2[i]=y1[i]-tau*u*((y1[i+1]-y1[i-1]))/(2*h)
        }
        y1=y2
        counter+=tau
    }
    return Pair(y2,t)
}
fun cabaret():Pair<Array<Double>,Array<Double>>{
    var y1=Array(N+2){0.0}
    var y2=Array(N+2){0.0}
    var y3=Array(N+2){0.0}
    var y4=Array(N+2){0.0}
    y1[0]=func(0).toDouble()
    y2[0]=func(0).toDouble()
    y3[0]=func(0).toDouble()
    y4[0]=func(0).toDouble()
    var t= linspace(0,N.toDouble()+1,N+2)
    for(n in 1 until (N+1)){
        y1[n]=func(n).toDouble()
        y2[n]=y1[n]-tau*u*(y1[n]-y1[n-1])/h
    }
    var counter=0.0
    while(counter<T){
        for(i in 1 until N+1) {
            counter+=tau

            y3[i]=y2[i]-(y2[i-1]-y1[i-1])-2*tau*u*(y2[i]-y2[i-1])/h
        }
        y1=y2
        y2=y3
        counter+=tau
    }
    return Pair(y3,t)
}
fun centralCabaret():Pair<Array<Double>,Array<Double>>{
    var y1=Array(N+2){0.0}
    var y2=Array(N+2){0.0}
    var y3=Array(N+2){0.0}
    var y4=Array(N+2){0.0}
    y1[0]=func(0).toDouble()
    y2[0]=func(0).toDouble()
    y3[0]=func(0).toDouble()
    y4[0]=func(0).toDouble()
    var t= linspace(0,N.toDouble()+1,N+2)
    for(n in 1 until (N+1)){
        y1[n]=func(n).toDouble()
        y2[n]=y1[n]+tau*u*(y1[n]-y1[n-1])/h
    }
    var counter=0.0
    while(counter<T){
        for(i in 1 until N+1) {
            counter+=tau

            y3[i]=y2[i]-(y2[i-1]-y1[i-1])/2-tau*u*(y2[i+1]+4*y2[i]-5*y2[i-1])/(4*h)
        }
        y1=y2
        y2=y3
        counter+=tau
    }
    return Pair(y3,t)
}

