package q9intset

/**
  * Created by peted on 01/03/2016.
  */
//9. Given the following code:
trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  //Q) intuitively, I want to put the union and intersection methods
  //into a companion object
  def union(ints:IntSet):IntSet = ints match{
    case EmptySet() => this
      //q) how to rep the case of this being the empty set - use a nested match?
    case NonEmptySet(elem , left , right) =>
  }

}
case class EmptySet() extends IntSet {
  //Q) whys not object - there is only one empty set?
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet =
    new NonEmptySet(x, new EmptySet, new EmptySet)
}
case class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def contains(x: Int): Boolean =
    if (x < elem) left contains x // use of the call without brackets approach
    else if (x > elem) right contains x
    else true
  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
}
//Q) why would we set up the code in this way?
//Q) why hasn't he used pattern matching within the contains and incl method,
// even though he is using the polymorphic approach?
/*Write methods union and intersection to form the union and intersection between
two sets.
Add a method to return the given set without the element x.
To accomplish this, it is useful to also implement a test method
def isEmpty: Boolean
for sets.*/

/* eg
A [] -> [5,(),()] -> [5,  (3,  (e),  (e))  ,   (8,  (e),  (e) )]
                  -> [5,  (3,  (e),  (e))  ,   (8,  (e),  (e) )]
                  -> [5,  (3,  (e),  (e))  ,   (8,  (e),  (9, (e) (e) )]


B [] -> [7,(),()] -> [7,(2,5,6),(10)]

C = A U B

 what we want    [   ]

