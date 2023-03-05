package com.programming.techie.springredditclone.service;

import com.programming.techie.springredditclone.exceptions.SpringRedditException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CommentServiceTest {

    @Test
    @DisplayName("Test Should Pass When Comment Do Not Contain Swear")
    void shouldNotContainsSwearWordsInsideComment() {

        CommentService commentService = new CommentService(null, null, null, null, null, null, null);
        Assertions.assertFalse(commentService.containsSwearWords("This is a comment without swear words"));
    }

    @Test
    @DisplayName("Should Throw Exception when Exception Contains Swear Words")
    void shouldFailWhenCommentContainsSwearWords() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);

        assertThatThrownBy(() -> {
            commentService.containsSwearWords("This is a shitty comment");
        }).isInstanceOf(SpringRedditException.class)
                .hasMessage("Comments contains unacceptable language");
    }
}