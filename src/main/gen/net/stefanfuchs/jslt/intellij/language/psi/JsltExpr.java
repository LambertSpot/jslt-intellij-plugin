// This is a generated file. Not intended for manual editing.
package net.stefanfuchs.jslt.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JsltExpr extends PsiElement {

  @NotNull
  List<JsltOrExpr> getOrExprList();

  @NotNull
  List<JsltPipeOperator> getPipeOperatorList();

}
