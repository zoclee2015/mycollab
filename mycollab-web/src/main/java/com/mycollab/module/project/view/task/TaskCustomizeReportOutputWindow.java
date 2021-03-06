/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycollab.module.project.view.task;

import com.mycollab.common.TableViewField;
import com.mycollab.db.query.VariableInjector;
import com.mycollab.module.project.ProjectTypeConstants;
import com.mycollab.module.project.domain.SimpleTask;
import com.mycollab.module.project.domain.criteria.TaskSearchCriteria;
import com.mycollab.module.project.i18n.OptionI18nEnum.TaskPriority;
import com.mycollab.module.project.i18n.TaskI18nEnum;
import com.mycollab.module.project.service.ProjectTaskService;
import com.mycollab.reporting.CustomizeReportOutputWindow;
import com.mycollab.spring.AppContextUtil;
import com.mycollab.vaadin.UserUIContext;
import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author MyCollab Ltd
 * @since 5.3.4
 */
public class TaskCustomizeReportOutputWindow extends CustomizeReportOutputWindow<TaskSearchCriteria, SimpleTask> {
    public TaskCustomizeReportOutputWindow(VariableInjector<TaskSearchCriteria> variableInjector) {
        super(ProjectTypeConstants.TASK, UserUIContext.getMessage(TaskI18nEnum.LIST), SimpleTask.class,
                AppContextUtil.getSpringBean(ProjectTaskService.class), variableInjector);
    }

    @Override
    protected Object[] buildSampleData() {
        return new Object[]{"Task A", "Note 1", UserUIContext.formatDate(new LocalDate().minusDays(2).toDate()),
                UserUIContext.formatDate(new LocalDate().plusDays(1).toDate()), UserUIContext.formatDate(new LocalDate().plusDays(1).toDate()),
                TaskPriority.High.name(), "50", "Will Smith", "Jonh Adam", "3", "1", "true",
                "Project Closing", "3", "2"};
    }

    @Override
    protected Collection<TableViewField> getDefaultColumns() {
        return Arrays.asList(TaskTableFieldDef.taskname(), TaskTableFieldDef.startdate(), TaskTableFieldDef.duedate(),
                TaskTableFieldDef.priority(), TaskTableFieldDef.percentagecomplete(), TaskTableFieldDef.assignee(),
                TaskTableFieldDef.billableHours(), TaskTableFieldDef.nonBillableHours());
    }

    @Override
    protected Collection<TableViewField> getAvailableColumns() {
        return Arrays.asList(TaskTableFieldDef.taskname(), TaskTableFieldDef.note(), TaskTableFieldDef.startdate(),
                TaskTableFieldDef.enddate(), TaskTableFieldDef.duedate(),
                TaskTableFieldDef.priority(), TaskTableFieldDef.percentagecomplete(), TaskTableFieldDef.logUser(),
                TaskTableFieldDef.assignee(), TaskTableFieldDef.originalEstimate(), TaskTableFieldDef.remainEstimate(),
                TaskTableFieldDef.isEstimate(), TaskTableFieldDef.milestoneName(),
                TaskTableFieldDef.billableHours(), TaskTableFieldDef.nonBillableHours());
    }
}
