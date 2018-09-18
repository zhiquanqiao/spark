package customsort

/**
  * Created by qiaozhiquan on 2018/9/18.
  */
object SortRules {

  implicit object OrderingFleshMan extends Ordering[FleshMan] {
    override def compare(x: FleshMan, y: FleshMan): Int = {

      if (x != null && y != null) {
        if (x.fv == y.fv) {
          x.age - y.age
        } else {
          x.fv - y.fv
        }
      } else {
        0
      }

    }
  }

}
