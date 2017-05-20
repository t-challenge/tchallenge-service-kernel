package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.ValidatorService;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.family.TaskFamilyRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.tags.TaskTagRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericValidator;

@ValidatorService
public class TaskValidatorBean extends GenericValidator implements TaskValidator {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusRepository statusRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TaskCategoryRepository categoryRepository;

    @Autowired
    private TaskDifficultyRepository difficultyRepository;

    @Autowired
    private TaskFamilyRepository familyRepository;

    @Autowired
    private TaskMindflowRepository mindflowRepository;

    @Autowired
    private TaskWorkflowRepository workflowRepository;

    @Autowired
    private TaskExpectationRepository expectationRepository;

    @Autowired
    private TaskTagRepository tagRepository;

    @Autowired
    private TaskOwnershipRepository ownershipRepository;

    @Override
    public TaskInvoice ensureForCreate(final TaskInvoice invoice) {
        return ensureForCreateOrUpdate(invoice);
    }

    @Override
    public TaskInvoice ensureForUpdate(final TaskInvoice invoice) {
        return ensureForCreateOrUpdate(invoice);
    }

    @Override
    public TaskInvoice ensureForUpdateStatus(final TaskInvoice invoice) {
        ensureInvoiceNotNull(invoice);
        if (invoice.getStatus() == null || statusRepository.findById(invoice.getStatus()) == null) {
            throw new RuntimeException("illegal task status");
        }
        return invoice;
    }

    private TaskInvoice ensureForCreateOrUpdate(final TaskInvoice invoice) {
        ensureInvoiceNotNull(invoice);
        if (invoice.getQuestion() == null) {
            throw new RuntimeException("question is null");
        }
        if (invoice.getCategories() == null || invoice.getCategories().size() == 0) {
            throw new RuntimeException("categories are missing");
        }
        invoice.getCategories().stream().forEach((c) -> {
            if (categoryRepository.findById(c) == null) {
                throw new RuntimeException("illegal category");
            }
        });
        if (invoice.getComplexity() == null || invoice.getComplexity() < 1) {
            throw new RuntimeException("illegal complexity");
        }
        if (invoice.getDifficulty() == null
                || difficultyRepository.findById(invoice.getDifficulty()) == null) {
            throw new RuntimeException("illegal of missing difficulty");
        }
        if (invoice.getFamilies() != null) {
            invoice.getFamilies().stream().forEach((f) -> {
                if (familyRepository.findById(f) == null) {
                    throw new RuntimeException("illegal family");
                }
            });
        }
        if (invoice.getMindflow() == null
                || mindflowRepository.findById(invoice.getMindflow()) == null) {
            throw new RuntimeException("illegal of missing mindflow");
        }
        if (invoice.getWorkflow() == null
                || workflowRepository.findById(invoice.getWorkflow()) == null) {
            throw new RuntimeException("illegal of missing workflow");
        }
        if (invoice.getExpectation() == null
                || expectationRepository.findById(invoice.getExpectation()) == null) {
            throw new RuntimeException("illegal of missing workflow");
        }
        return invoice;
    }

    private TaskInvoice ensureInvoiceNotNull(final TaskInvoice invoice) {
        if (invoice == null) {
            throw new RuntimeException("invoice is null");
        }
        return invoice;
    }
}
