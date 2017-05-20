package ru.tsystems.tchallenge.service.kernel.domain.task.snippet;

public interface TaskSnippetMapper {

    TaskSnippet asEntity(TaskSnippetInvoice invoice);

    TaskSnippet asEntityMerged(TaskSnippet entity, TaskSnippetInvoice invoice);

    TaskSnippetInfo asInfo(TaskSnippet snippet);
}
