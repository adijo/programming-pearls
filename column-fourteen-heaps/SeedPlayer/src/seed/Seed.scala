package seed

import scala.collection.mutable.Queue

class Seed {
  
  class Match(one : Int, two : Int, lvl : Int) {
      def getOne = one
      def getTwo = two
      def getLvl = lvl
      
      
    override def toString() = one + " x " + two
  }
  
  var matches = Set[Match]()
  
  def createSchedule(limit : Int) : Set[Match] = {
      
      if(limit < 2) throw new Exception("schedule must contain at least 2 players.")
      var q = new Queue[Match]()
      val first = new Match(1, 2, 0)    
      
      matches = matches.+(first)
      
      var currLvl = 0
      var candidates = List[Int]()
      q.+=:(first)
      
      while(!q.isEmpty) {
        val curr = q.dequeue
        matches = matches.+(curr)
        if(candidates.length == 0) {
          
            currLvl = curr.getLvl + 1
            if(currLvl > limit) matches
            candidates = createCandidates(currLvl)
            if(currLvl <= limit) {
                 val matchOne = new Match(curr.getOne, candidates.head, currLvl)
              candidates = candidates.tail
            val matchTwo = new Match(curr.getTwo, candidates.head, currLvl)
            candidates = candidates.tail
            q.+=:(matchOne)
            q.+=:(matchTwo)
              
            }
         
        }
        
        else {
            currLvl = curr.getLvl + 1
              if(currLvl <= limit) {
                 val matchOne = new Match(curr.getOne, candidates.head, currLvl)
              candidates = candidates.tail
            val matchTwo = new Match(curr.getTwo, candidates.head, currLvl)
            candidates = candidates.tail
            q.+=:(matchOne)
            q.+=:(matchTwo)
              
            }
        }
        
      }
      matches
  }
  
  def createCandidates(lvl : Int) : List[Int] = 
    util.Random.shuffle(List.range(scala.math.pow(2, lvl).toInt + 1, scala.math.pow(2, lvl + 1).toInt + 1))
  
 
 
  
  
}

