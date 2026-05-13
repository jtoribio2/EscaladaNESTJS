import {
  Controller,
  Get,
  Param,
  Query,
} from '@nestjs/common';

import { EscolesService } from './escoles.service';

import { FilterEscolaDto } from './dto/filter-escola.dto';

@Controller('escoles')
export class EscolesController {

  constructor(
    private readonly escolesService: EscolesService,
  ) {}

  @Get()
  findAll(
    @Query() filters: FilterEscolaDto,
  ) {

    return this.escolesService.findAll(filters);
  }

  @Get(':id')
  findOne(
    @Param('id') id: string,
  ) {

    return this.escolesService.findOne(Number(id));
  }
}