package com.turgayozdemir.patikacoroutines

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        //PAGE 6
        CoroutineScope (IO).launch {
            delay(10000)
            println("Coroutine tamamlandı")

        }
        */



        /*
        //PAGE 7
        val deferred = GlobalScope.async {
            "Merhaba!"
        }
        runBlocking {
            val mesaj = deferred.await()
            println(mesaj)
        }
        */



        /*
        //PAGE 8
        runBlocking {
            delay(5000)
            println("Coroutine tamamlandı")
        }
        */



        /*
        //PAGE 9
        CoroutineScope(Dispatchers.Main).launch {
            val text = "UI güncellendi!"
            //textView.text = text
        }
         */



        /*
        //PAGE 10
        CoroutineScope(IO).launch {
            val url = "https://example.com/api/data"
            val response = URL(url).readText()
            println(response)
        }
         */



        /*
        //PAGE 11
        CoroutineScope(Dispatchers.Default).launch {
            var sum = 0
            for (i in 0..10000) {
                sum += i
            }
            println("Toplam: $sum")
        }
         */



        /*
        //PAGE 12
        val url = "https://api.example.com/data"

        CoroutineScope(IO).launch {
            withContext(Dispatchers.IO) {
                val response = URL(url).readText()
                println("Veri: $response")
            }
        }

        val scope = CoroutineScope(IO)

        fun myCoroutine(job: Job) {
            scope.launch {
                withContext(job) {

                }
            }
        }
         */



        /*
        //PAGE 13
        val scope = CoroutineScope(IO)
        val job = Job()

        scope.launch(job) {
        }
        job.cancel()
        */



        /*
        //PAGE 15
        fun getNumbers(delay: Long): List<Int> {
            val numbers = mutableListOf<Int>()
            for (i in 1..10) {
                Thread.sleep(delay)
                numbers.add(i)
            }
            return numbers
        }

        fun main() {
            val numbers = getNumbers(100)
            for (number in numbers) {
                println(number)
            }
        }
         */



        /*
        //PAGE 16
        fun getNumbersFlow(delay: Long): Flow<Int> {
            return flow {
                for (i in 1..10) {
                    emit(i)
                    delay(delay)
                }
            }
        }

        fun main() {
            val flow = getNumbersFlow(100)
            launch {
                for (number in flow) {
                    println(number)
                }
            }
        }
         */



        /*
        //PAGE 17
        val scope = CoroutineScope(IO)

        scope.launch {
        }
         */



        /*
        //PAGE 18
        val supervisorJob = SupervisorJob()
        val scope = CoroutineScope(supervisorJob)

        scope.launch {
        }

        scope.launch {
        }
         */



        /*
        //PAGE 19
        val supervisorJob = SupervisorJob()
        val scope = CoroutineScope(unsupervisorJob)

        scope.launch {
        }

        scope.launch {
        }
         */



        /*
        //PAGE 20
        val uiScope = MainCoroutineScope()

        uiScope.launch {
        }
         */



        /*
        //PAGE 21
        val supervisorScope = SupervisorScope()

        supervisorScope.launch {

        }
        */



        /*
        //PAGE 23
        val flow = flow {
            emit(1)
            emit(2)
            emit(3)
        }
        flow.collect { değer -> println(değer) }
         */



        /*
        //PAGE 24
        val sayilar = listOf(1, 2, 3)
        val flow = sayilar.asFlow()

        flow.collect { değer -> println(değer) }
        */



        /*
        //PAGE 25
        val sayilarFlow = flow {
            emit(1)
            emit(2)
            emit(3)
        }
        val karelerFlow = sayilarFlow.map { sayi -> sayi * sayi }
        karelerFlow.collect { kare -> println(kare) }
        */



        /*
        //PAGE 26
        val sayilarFlow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
            emit(5)
        }
        val teklerFlow = sayilarFlow.filter { sayi -> sayi % 2 == 1 }
        teklerFlow.collect { tek -> println(tek) }
        */



        /*
        //PAGE 27
        suspend fun performRequest(request: Int): String {
            delay(1000)
            return "response $request"
        }
        fun main() = runBlocking<Unit> {
            (1..3).asFlow()
                .transform { request ->
                    emit("Making request $request")
                    emit(performRequest(request))
                }
                .collect { response -> println(response) }
        }
         */



        /*
        //PAGE 28
        val sayilarFlow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
            emit(5)
        }
        sayilarFlow
            .flowOn(Dispatchers.IO)
            .collect { sayi -> println(sayi) }
         */



        /*
        //PAGE 31
        fun main() = runBlocking {
            val kanal = Channel<Int>()

            launch {
                println("Gönderici başlatıldı")
                kanal.send(10)
                println("Değer gönderildi: 10")
            }

            launch {
                println("Alıcı başlatıldı")
                val deger = kanal.receive()
                println("Değer alındı: $deger")
            }
        }
         */



        /*
        //PAGE 32
        fun main() = runBlocking {
            val kanal = Channel<String>()

            launch {
                println("Gönderici başlatıldı")
                for (i in 1..5) {
                    kanal.send("Mesaj $i")
                    println("Mesaj gönderildi: Mesaj $i")
                }
            }

            launch {
                println("Alıcı başlatıldı")
                while (true) {
                    val mesaj = kanal.receive()
                    println("Mesaj alındı: $mesaj")
                }
            }
        }
         */



        /*
        //PAGE 33
        fun main() = runBlocking {
            val kanal = ticker(1000, 0)
            launch {
                println("Alıcı başlatıldı")
                while (true) {
                    kanal.receive()
                    println("Tıklama alındı")
                }
            }
            delay(5000)
        }
        */

    }
}