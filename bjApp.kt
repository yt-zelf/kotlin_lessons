import java.util.*

abstract player{
  var score : Int

  fun addscore(draw : Int) : Int {

  }
}

class deck{
  var card : Array<Boolean?> = arrayOfNulls(54)

  fun draw() : Int {
    val rand = Random()
    var r : Int
    do{
      r = rand.nextInt(53)
      }while(card[r]==true)
      return r
  }
}

/*
fun drawcard(card : Array<Boolean?>) : Int{
  val rand = Random()
  var r : Int


  fun mark(draw : Int) = when((draw+1)/13){
    3 -> "スペード"
    2 -> "クラブ"
    1 -> "ダイヤ"
    0 -> "ハート"
    else -> "error"
  }

  fun main(args: Array<String>){
    var card : Array<Boolean?> = arrayOfNulls(54)
    var draw : Int
    var player : MutableList<Int> = mutableListOf()
    var dealer : MutableList<Int> = mutableListOf()
    var playersum = 0
    var dealersum = 0

    draw = drawcard(card)
    player.add(draw); card[draw] = true
    if((draw%13+1)>10)  playersum += 10
    else                playersum += draw%13+1
    println("あなたが引いたカードは ${mark(draw)}の${draw % 13+1}")
    println("現在の合計は $playersum です")

    draw = drawcard(card)
    player.add(draw); card[draw] = true
    if((draw%13+1)>10)  playersum += 10
    else                playersum += draw%13+1
    println("あなたが引いたカードは ${mark(draw)}の${draw % 13+1}")
    println("現在の合計は $playersum です")

    draw = drawcard(card)
    dealer.add(draw); card[draw] = true
    if((draw%13+1)>10)  dealersum += 10
    else                dealersum += draw%13+1
    println("相手が引いたカードは ${mark(draw)}の${draw % 13+1}")
    println("現在の合計は $dealersum です")

    draw = drawcard(card)
    dealer.add(draw); card[draw] = true
    println("相手がカードを引きました")
    if((draw%13+1)>10)  dealersum += 10
    else                dealersum += draw%13+1

    println("あなたの現在の合計は $playersum です")
    var input : String?
    while(true){
      println("あなたの手番です。カードを引きますか？(YES/NO)")
      input = readLine()
      if(input == "NO") break
      else if(input == "YES"){
        draw = drawcard(card)
        player.add(draw); card[draw] = true
        if((draw%13+1)>10)  playersum += 10
        else                playersum += draw%13+1
        println("あなたが引いたカードは ${mark(draw)}の${draw % 13+1}")
        println("現在の合計は $playersum です")
        }else{
          println("正しく入力してください")
          continue
        }
      }

      println("相手の手番です。")
      while(dealersum < 17){
        draw = drawcard(card)
        dealer.add(draw); card[draw] = true
        if((draw%13+1)>10)  dealersum += 10
        else                dealersum += draw%13+1
        println("相手が引いたカードは ${mark(draw)}の${draw % 13+1}")
      }

      println("あなたのカードの合計は $playersum です")
      println("相手のカードの合計は $dealersum です")

      if(playersum > 20){
        if(dealersum > 20)  println("引き分けです")
        else                println("あなたの負けです")
      }else if(dealersum > 20) println("あなたの勝ちです")
      else{
        if(Math.abs(21-playersum) - Math.abs(21-dealersum) > 0)
              println("あなたの負けです")
        else  println("あなたの勝ちです")
      }



    } */
