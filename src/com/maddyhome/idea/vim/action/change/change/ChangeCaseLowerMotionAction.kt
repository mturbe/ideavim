/*
 * IdeaVim - Vim emulator for IDEs based on the IntelliJ platform
 * Copyright (C) 2003-2019 The IdeaVim authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.maddyhome.idea.vim.action.change.change;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.maddyhome.idea.vim.VimPlugin;
import com.maddyhome.idea.vim.action.DuplicableOperatorAction;
import com.maddyhome.idea.vim.command.Argument;
import com.maddyhome.idea.vim.command.Command;
import com.maddyhome.idea.vim.handler.ChangeEditorActionHandler;
import com.maddyhome.idea.vim.helper.CharacterHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class ChangeCaseLowerMotionAction extends ChangeEditorActionHandler.ForEachCaret
  implements DuplicableOperatorAction {

  @NotNull
  @Override
  public Command.Type getType() {
    return Command.Type.CHANGE;
  }

  @NotNull
  @Override
  public Argument.Type getArgumentType() {
    return Argument.Type.MOTION;
  }

  @Override
  public boolean execute(@NotNull Editor editor,
                         @NotNull Caret caret,
                         @NotNull DataContext context,
                         int count,
                         int rawCount,
                         @Nullable Argument argument) {
    return argument != null &&
           VimPlugin.getChange()
             .changeCaseMotion(editor, caret, context, count, rawCount, CharacterHelper.CASE_LOWER, argument);
  }

  @Override
  public char getDuplicateWith() {
    return 'u';
  }
}