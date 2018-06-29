import java.util.*

abstract class PlayerBase{
  private var hand : MutableList<Card> = mutableListOf()
  private var score = 0
  private var burst : Boolean = false

  abstract fun playerTurn(deck :Deck)
  abstract fun playerInit(deck :Deck)

  fun addhand(draw : Card){
    hand.add(draw)
  }

  fun getScore():Int{
    score = 0
    for(card in hand) score += card.getPoint()

    return score
  }

  fun isBurst():Boolean{
    if (getScore() > 21) burst = true
    return burst
  }
}

class User :PlayerBase(){
  lateinit var draw:Card
  override fun playerInit(deck :Deck){
    draw = deck.drawCard()
    addhand(draw)
    println("あなたは${draw.getNoString()}を引きました")
    draw = deck.drawCard()
    addhand(draw)
    println("あなたは${draw.getNoString()}を引きました")

    println("あなたの点数は${getScore()}点です\n")
  }

  override fun playerTurn(deck :Deck){
    var input : String?
    lateinit var draw:Card
    do{
      println("カードを引きますか？(Y/N)")
      input = readLine()
      when (input) {
        "Y" -> {
          draw = deck.drawCard()
          addhand(draw)
          println("あなたは${draw.getNoString()}を引きました")
          println("あなたの点数は${getScore()}点です\n")
        }
        "N" -> println("あなたの手番を終了します\n")
        else-> println("正しく入力してください")
      }
    }while(input != "N")
  }
}

class Dealer :PlayerBase(){
  private lateinit var draw:Card
  override fun playerInit(deck :Deck){
    draw = deck.drawCard()
    addhand(draw)
    println("相手が${draw.getNoString()}を引きました")
    draw = deck.drawCard()
    addhand(draw)
    println("相手がカードを1枚引きました\n")
  }

  override fun playerTurn(deck :Deck){
    while(getScore()<17){
      draw = deck.drawCard()
      addhand(draw)
      println("相手が${draw.getNoString()}を引きました")
    }
    println("相手の手番を終了します\n")
  }
}


class Card(var number: Int,var mark: String){
  fun getNum() :Int = number
  fun getPoint() :Int = when(number){
    in 10..13 -> 10
    else      -> number
  }
  fun getNoString() :String{
    var num :String = when(number) {
      1  -> "A"
      11 -> "J"
      12 -> "Q"
      13 -> "K"
      else -> "$number"
    }
    return mark+"の"+num
    }
}

class Deck{
  var cardList : MutableList<Card> = mutableListOf()

  fun deckInit(){
    for (i in 1..13){
      cardList.add(Card(i,"スペード"))
      cardList.add(Card(i,"  クラブ"))
      cardList.add(Card(i,"  ダイヤ"))
      cardList.add(Card(i,"  ハート"))
    }
  }

  fun drawCard():Card{
    val r = Random().nextInt(cardList.count()-1)
    val return_Card = cardList.elementAt(r)

    cardList.removeAt(r)
    return return_Card
  }

  /* fun deckView(){
    for(card in cardList)
    println(card.getNoString())
  } */
}

class Result{
  fun calcScore(user:User,dealer:Dealer){
    if(user.isBurst() && dealer.isBurst())
      println("Both Burst,DRAW")
    else if(user.isBurst())
      println("Your Burst,LOSE")
    else if(dealer.isBurst())
      println("Dealer Burst,WIN")
    else if(user.getScore() < dealer.getScore())
      println("Dealer has more point,LOSE")
    else if(user.getScore() > dealer.getScore())
      println("Your have more point,WIN")
    else
      println("Point is a tie,DRAW")

    println("USER ${user.getScore()},DEALER ${dealer.getScore()}")
  }
}

fun main(args: Array<String>){
  var deck = Deck()
  var user = User()
  var dealer = Dealer()
  var result = Result()

  deck.deckInit()
  /* deck.deckView() */

  user.playerInit(deck)
  dealer.playerInit(deck)
  user.playerTurn(deck)
  dealer.playerTurn(deck)

  result.calcScore(user,dealer)
  //view result
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
