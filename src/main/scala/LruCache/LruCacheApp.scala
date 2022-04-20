package LruCache

object LruCacheApp extends App {




}

case class Node(left: Option[Node], right: Option[Node], key: Int, value: String)

class LruCache {
  val size = 50
  var head: Node
  var tail: Node
}

case class DoubleLinkedList(val size: Int, val head: Option[Node] = None,  val tail: Option[Node] = None) {

  def remove(node: Node): DoubleLinkedList = {
    node match {
      case Node(left, right, _, _) if left == None && right == None => DoubleLinkedList(size)
      case Node(left, right, key, value) if left == None => DoubleLinkedList(size, Node(None, right), tail)
      case Node(_, right, _, _) if right == None =>DoubleLinkedList(size, head, node.left)
      case Node(left, right, _, _) =>
    }
  }
}

