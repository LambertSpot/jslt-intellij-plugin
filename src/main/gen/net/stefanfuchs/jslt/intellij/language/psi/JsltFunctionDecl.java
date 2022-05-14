// This is a generated file. Not intended for manual editing.
package net.stefanfuchs.jslt.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface JsltFunctionDecl extends PsiElement {

  @NotNull
  JsltFunctionBody getFunctionBody();

  @Nullable
  JsltFunctionDeclParamList getFunctionDeclParamList();

  @Nullable
  String getName();

  @NotNull
  ItemPresentation getPresentation();

  //WARNING: getLetAssignmentList(...) is skipped
  //matching getLetAssignmentList(JsltFunctionDecl, ...)
  //methods are not found in JsltPsiImplUtil

  @NotNull
  JsltExpr getExpr();

}
