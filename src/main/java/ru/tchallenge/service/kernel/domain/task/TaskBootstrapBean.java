package ru.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.domain.account.AccountBootstrap;
import ru.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tchallenge.service.kernel.domain.task.image.content.TaskImageContentRepository;
import ru.tchallenge.service.kernel.domain.task.image.format.TaskImageFormatBootstrap;
import ru.tchallenge.service.kernel.domain.task.image.format.TaskImageFormatRepository;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowBootstrap;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowRepository;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategoryBootstrap;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyBootstrap;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectationBootstrap;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipBootstrap;
import ru.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipRepository;
import ru.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleBootstrap;
import ru.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleRepository;
import ru.tchallenge.service.kernel.domain.task.status.TaskStatusBootstrap;
import ru.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowBootstrap;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowRepository;
import ru.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskBootstrapBean extends OrdinalEntityBootstrap<Task> {

    @Autowired
    private TaskHeisenbugProviderBean heisenbugTaskProvider;

    @Autowired
    private AccountBootstrap accountBootstrap;

    @Autowired
    private TaskCategoryBootstrap categoryBootstrap;

    @Autowired
    private TaskExpectationBootstrap expectationBootstrap;

    @Autowired
    private TaskDifficultyBootstrap difficultyBootstrap;

    @Autowired
    private TaskStatusBootstrap statusBootstrap;

    @Autowired
    private TaskWorkflowBootstrap workflowBootstrap;

    @Autowired
    private TaskMindflowBootstrap mindflowBootstrap;

    @Autowired
    private TaskOwnershipBootstrap ownershipBootstrap;

    @Autowired
    private TaskImageFormatBootstrap imageFormatBootstrap;

    @Autowired
    private TaskSnippetStyleBootstrap snippetStyleBootstrap;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskCategoryRepository categoryRepository;

    @Autowired
    private TaskDifficultyRepository difficultyRepository;

    @Autowired
    private TaskExpectationRepository expectationRepository;

    @Autowired
    private TaskStatusRepository statusRepository;

    @Autowired
    private TaskWorkflowRepository workflowRepository;

    @Autowired
    private TaskMindflowRepository mindflowRepository;

    @Autowired
    private TaskOwnershipRepository ownershipRepository;

    @Autowired
    private TaskImageFormatRepository imageFormatRepository;

    @Autowired
    private TaskSnippetStyleRepository snippetStyleRepository;

    @Autowired
    private TaskImageContentRepository imageContentRepository;

    @Override
    protected void collectEntities(final Collection<Task> tasks) {
        tasks.addAll(heisenbugTaskProvider.getTasks());
    }

    @Override
    protected GenericEntityRepository<Task, Long> getRepository() {
        return taskRepository;
    }
}
