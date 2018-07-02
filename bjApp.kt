import java.util.*

abstract class PlayerBase{
  private val hand : MutableList<Card> = mutableListOf()
  private val score = 0
  private val burst : Boolean = false

  abstract fun drawCard(){}

  fun addhand(draw : Card){
    hand.add(draw)
  }

  fun getScore():Int{
    score = 0

    for(card in hand) score += card.getPoint

    return score
  }

  fun isBurst():Boolean{
    if (getScore() > 21) burst = true
    return burst
  }
}

class User :PlayerBase(){

}

class Dealer :PlayerBase(){

}


class Card{
  val number : Int
  val mark : String
  fun Card(num: Int, ma: String){
    numbar = num
    mark = ma
  }

  fun getNum() :Int = number
  fun getMark() :String = mark
  fun getPoint() :Int = when(number){
    in 10..13 -> 10
    else      -> number
  }
  fun getNoString() :String{
    var num :String = when(number) {
      1  -> 'A'
      11 -> 'J'
      12 -> 'Q'
      13 -> 'K'
      else -> "$number"
    }
    return "$mark の $num"
    }
}

class Deck{
  var cardList : MutableList<Card> = mutableListOf()

  fun deckInit(){
    for (i in 1..13){
      cardList.add(i,"スペード")
      cardList.add(i,"クラブ")
      cardList.add(i,"ダイヤ")
      cardList.add(i,"ハート")
    }
  }

  fun drawCard():Card{
    val draw:Card
    val rand = Random()
    val r = rand.nextInt(CardList.count()-1)

    draw = CardList.elementAt(r)

    return draw
  }

  fun deckView(){
    for(card in cardList)
    println(getNoString())
  }
}

fun main(args: Array<String>){
  var Deck = Deck()
  deck.deckinit()
  deck.deckView()

}


/*
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
