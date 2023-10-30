package dotty.tools.dotc.parsing

import dotty.tools.DottyTest
import dotty.tools.dotc.ast.Trees.{Ident, PackageDef, TypeDef}
import dotty.tools.dotc.ast.untpd.ModuleDef
import dotty.tools.dotc.core.Contexts.{Context, ContextBase}
import dotty.tools.dotc.core.StdNames.tpnme
import dotty.tools.dotc.printing.{PlainPrinter, Printer}
import dotty.tools.dotc.util.SourceFile
import dotty.tools.io.PlainFile
import org.junit.Assert.fail
import org.junit.Test

class JavaJep445ParserTest extends DottyTest {

  @Test def `parses unnamed class`: Unit = {
    val code =
      s"""
         |// hello
         |
         |import some.pkg.*;
         |
         |private volatile int x = 0;
         |private String s = "s";
         |
         |void main() {}
         |""".stripMargin

    val parser =
      JavaParsers.JavaParser(SourceFile.virtual("MyUnnamed.java", code))
    val tree = parser.parse()

    println(tree.show)

    fail("TODO")
  }

  @Test def `treats leading top-level types as nested types of unnamed class`: Unit = {
    val code =
      s"""
         |// hello
         |
         |import some.pkg.*;
         |
         |interface Inner {}
         |
         |void main() {}
         |""".stripMargin

    val parser =
      JavaParsers.JavaParser(SourceFile.virtual("MyUnnamed.java", code))
    val tree = parser.parse()

    println(tree.show)

    fail("TODO")
  }
}
