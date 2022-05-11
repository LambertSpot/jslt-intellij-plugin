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

public class JsltChainableImpl extends ASTWrapperPsiElement implements JsltChainable {

  public JsltChainableImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsltVisitor visitor) {
    visitor.visitChainable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsltVisitor) accept((JsltVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JsltChainLink getChainLink() {
    return findChildByClass(JsltChainLink.class);
  }

  @Override
  @Nullable
  public JsltFunctionCall getFunctionCall() {
    return findChildByClass(JsltFunctionCall.class);
  }

  @Override
  @Nullable
  public JsltVariableUsage getVariableUsage() {
    return findChildByClass(JsltVariableUsage.class);
  }

}
