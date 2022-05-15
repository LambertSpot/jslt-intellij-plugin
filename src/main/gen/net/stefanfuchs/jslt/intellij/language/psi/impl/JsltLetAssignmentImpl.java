// This is a generated file. Not intended for manual editing.
package net.stefanfuchs.jslt.intellij.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.stefanfuchs.jslt.intellij.language.psi.JsltTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.stefanfuchs.jslt.intellij.language.psi.*;
import net.stefanfuchs.jslt.intellij.language.psi.util.JsltPsiImplUtil;
import com.intellij.navigation.ItemPresentation;

public class JsltLetAssignmentImpl extends ASTWrapperPsiElement implements JsltLetAssignment {

  public JsltLetAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsltVisitor visitor) {
    visitor.visitLetAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsltVisitor) accept((JsltVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public JsltExpr getExpr() {
    return findNotNullChildByClass(JsltExpr.class);
  }

  @Override
  @NotNull
  public JsltLetVariableDecl getLetVariableDecl() {
    return findNotNullChildByClass(JsltLetVariableDecl.class);
  }

  @Override
  @Nullable
  public String getName() {
    return JsltPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return JsltPsiImplUtil.getPresentation(this);
  }

}
