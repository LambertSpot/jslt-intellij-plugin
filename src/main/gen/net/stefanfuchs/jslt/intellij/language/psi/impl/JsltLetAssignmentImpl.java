// This is a generated file. Not intended for manual editing.
package net.stefanfuchs.jslt.intellij.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.stefanfuchs.jslt.intellij.language.psi.JsltTypes.*;
import net.stefanfuchs.jslt.intellij.language.psi.*;
import com.intellij.navigation.ItemPresentation;

public class JsltLetAssignmentImpl extends JsltVariableElementImpl implements JsltLetAssignment {

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
  @Nullable
  public String getName() {
    return JsltPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String newAlias) {
    return JsltPsiImplUtil.setName(this, newAlias);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return JsltPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return JsltPsiImplUtil.getPresentation(this);
  }

}
